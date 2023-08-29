package dev.hossam.cryptocurrency.feature_cryptocurrencies.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import dev.hossam.cryptocurrency.R
import dev.hossam.cryptocurrency.core.UiEvent
import dev.hossam.cryptocurrency.core.constant.Const
import dev.hossam.cryptocurrency.databinding.FragmentCryptocurrencyBinding
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.dto.CryptocurrencyDTO
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CryptocurrencyFragment : Fragment(), PopupMenu.OnMenuItemClickListener {

    private var _binding: FragmentCryptocurrencyBinding? = null
    private var popMenu: PopupMenu? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<CryptocurrencyViewModel>()
    private var cryptoAdapter: CryptocurrencyAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cryptoAdapter = CryptocurrencyAdapter()
        _binding = FragmentCryptocurrencyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collectUiState()
        showPopMenu()
        collectUiEvents()
        onClick()
    }

    private fun onClick(){
        cryptoAdapter?.onClick = { coinId ->
            findNavController().navigate(CryptocurrencyFragmentDirections
                .actionCryptocurrencyFragmentToCryptoDetailsFragment(coinId!!)
            )
        }
    }
    private fun collectUiState(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED){
                viewModel.state.collectLatest { state ->
                    setupRecyclerUi(state.cryptocurrencies)
                }
            }
        }
    }

    private fun collectUiEvents() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiEvent.collectLatest { uiEvent ->
                when(uiEvent){
                    is UiEvent.SnackBar -> Snackbar.make(binding.rvCryptocurrencies, uiEvent.message, Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
        private fun setupRecyclerUi(data: List<CryptocurrencyDTO>){
        cryptoAdapter?.setList(data)
        binding.rvCryptocurrencies.apply {
            adapter = cryptoAdapter
        }
    }

    private fun showPopMenu(){
        binding.ivBtnPopMenu.setOnClickListener {
        context?.let { mContext ->
            popMenu = PopupMenu(mContext, it)
            popMenu?.setOnMenuItemClickListener(this)
            popMenu?.inflate(R.menu.order_menu)
            popMenu?.show()
            }
        }
    }

    override fun onMenuItemClick(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId){
            Const.PopMenu.DESCENDING -> {
                viewModel.onEvent(OrderBy.Descending)
                true
            }
            Const.PopMenu.ASCENDING -> {
                viewModel.onEvent(OrderBy.Ascending)
                true
            }
            else -> false
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        cryptoAdapter = null
        _binding = null
    }

}