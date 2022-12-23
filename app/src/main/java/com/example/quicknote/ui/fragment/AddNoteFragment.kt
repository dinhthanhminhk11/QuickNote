package com.example.quicknote.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quicknote.R
import com.example.quicknote.databinding.FragmentAddNoteBinding
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set transitions here so we are able to access Fragment's binding views.
        enterTransition = MaterialContainerTransform().apply {
            // Manually add the Views to be shared since this is not a standard Fragment to
            // Fragment shared element transition.
            startView = requireActivity().findViewById(R.id.fab)
            endView = binding.contentBackground
//                duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
            // Optionally add a curved path to the transform
            setPathMotion(MaterialArcMotion())

            duration = 800
            scrimColor = Color.TRANSPARENT
//            containerColor = requireContext().themeColor(R.attr.colorSurface)
//            startContainerColor = requireContext().themeColor(R.attr.colorSecondary)
//            endContainerColor = requireContext().themeColor(R.attr.colorSurface)
        }
//        returnTransition = Slide().apply {
//            duration = resources.getInteger(R.integer.reply_motion_duration_medium).toLong()
//            addTarget(binding.contentBackground)
//        }

        initView(

        )
    }

    private fun initView() {
//        binding.click.setOnClickListener {
//           activity?.onBackPressed()
//        }
    }
}