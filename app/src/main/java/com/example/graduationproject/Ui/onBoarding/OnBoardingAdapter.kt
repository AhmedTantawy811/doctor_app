package com.example.graduationproject.Ui.onBoarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardingAdapter(activity: FragmentActivity, private val pagerList:ArrayList<page>):
    FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return pagerList.size
    }

    override fun createFragment(position: Int): Fragment {
        return OnBoardingFragment(pagerList [position])
    }
}