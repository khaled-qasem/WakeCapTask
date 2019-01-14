package com.khaled.wakecap.wakecaptask.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class WorkersPagerAdapter(
    fragmentManager: FragmentManager,
    private val roles: List<String>
) : FragmentPagerAdapter(fragmentManager) {
    
    override fun getItem(position: Int): Fragment {
        if (position < roles.size) {
            return WorkersFragment.newInstance(roles[position])
        } else {
            throw IllegalStateException("can't return fragment on position $position")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position < roles.size) {
            roles[position]
        } else {
            ""
        }
    }

    override fun getCount(): Int = roles.size

}