package com.khaled.wakecap.wakecaptask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment

class WorkersFragment : Fragment() {

    companion object {
        fun newInstance(role: String): WorkersFragment =
            WorkersFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ROLE, role)
                }
            }

        private val ARG_ROLE = WorkersFragment::class.java.name + "ARG_ROLE"
    }
}
