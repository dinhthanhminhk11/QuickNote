package com.example.quicknote.ui.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.transition.Slide
import com.example.quicknote.R
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform


class NotificationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emailCardView = view.findViewById<CardView>(R.id.email_card_view)

        // Set transitions here so we are able to access Fragment's binding views.
        enterTransition = MaterialContainerTransform().apply {
            // Manually add the Views to be shared since this is not a standard Fragment to
            // Fragment shared element transition.
            startView = requireActivity().findViewById(R.id.fab)
            endView = emailCardView
//                duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
            // Optionally add a curved path to the transform
            setPathMotion(MaterialArcMotion())

            duration = 1300
            scrimColor = Color.TRANSPARENT
//            containerColor = requireContext().themeColor(R.attr.colorSurface)
//            startContainerColor = requireContext().themeColor(R.attr.colorSecondary)
//            endContainerColor = requireContext().themeColor(R.attr.colorSurface)
        }
        returnTransition = Slide().apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_medium).toLong()
            addTarget(R.id.email_card_view)
        }
    }
}