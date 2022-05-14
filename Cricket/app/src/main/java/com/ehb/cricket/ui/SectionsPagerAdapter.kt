package com.ehb.cricket.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ehb.cricket.Country
import com.ehb.cricket.Match
import com.ehb.cricket.Player
import com.ehb.cricket.R

private val TAB_TITLES = arrayOf(
    R.string.tab_1,
    R.string.tab_2,
    R.string.tab_3
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        when(position){
            0 -> return Match()
            1 -> return Player()
            2 -> return Country()

            else -> {
                return PlaceholderFragment.newInstance(position + 1)
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show amount total pages (tabs).
        return TAB_TITLES.size
    }
}