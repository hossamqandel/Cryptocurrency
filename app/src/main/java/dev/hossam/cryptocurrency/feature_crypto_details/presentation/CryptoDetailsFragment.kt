package dev.hossam.cryptocurrency.feature_crypto_details.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import dev.hossam.cryptocurrency.R
import dev.hossam.cryptocurrency.databinding.FragmentCryptoDetailsBinding
import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.TagDTO
import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.TeamDTO
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CryptoDetailsFragment : Fragment() {

    private var _binding: FragmentCryptoDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<CryptoDetailsViewModel>()
    private var tagAdapter: TagsAdapter? = null
    private var teamAdapter: TeamAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tagAdapter = TagsAdapter()
        teamAdapter = TeamAdapter()
        _binding = FragmentCryptoDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collectUiState()
    }


    private fun collectUiState(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED){
                viewModel.state.collectLatest { state ->
//                    showHideUi(false)
                    setState(state)
                    setupTagsRecyclerUi(state.tags)
                    setupTeamRecyclerUi(state.team)
//                    showHideUi(true)
                }
            }
        }
    }

    private fun showHideUi(isVisible: Boolean){
        binding.apply {
            tvCryptoName.isGone = isVisible
            tvCryptoStatus.isGone = isVisible
            tvCryptoDesc.isGone = isVisible
            tvCryptoTags.isGone = isVisible
            rvCryptoTags.isGone = isVisible
            tvCryptoTeam.isGone = isVisible
            rvCryptoTeam.isGone = isVisible
        }
    }
    private fun setState(state: CryptoDetailsState){
        binding.apply {
            tvCryptoName.text = state.name
                .plus(" ")
                .plus("(${state.symbol})")
            tvCryptoStatus.text = if (state.isActive) getString(R.string.active) else getString(R.string.not_active)
            tvCryptoDesc.text = state.description
        }
    }

    private fun setupTagsRecyclerUi(data: List<TagDTO>){
        tagAdapter?.setList(data)
        binding.rvCryptoTags.adapter = tagAdapter
    }

    private fun setupTeamRecyclerUi(data: List<TeamDTO>){
        teamAdapter?.setList(data)
        binding.rvCryptoTeam.adapter = teamAdapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        tagAdapter = null
        teamAdapter = null
    }
}