package com.example.onboarding_mo5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.onboarding_mo5.databinding.ItemOnboardingBinding
import com.example.onboarding_mo5.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf<OnBoarding>(
        OnBoarding("", "title1", "desc1"),
        OnBoarding("", "title2", "desc2"),
        OnBoarding("", "title3", "desc3"),
        OnBoarding("", "title4", "desc4")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        fun onBind(boarding: OnBoarding) {
            binding.apply {
                tvTitle.text = boarding.title
                tvDescription.text = boarding.description
                btnStart.isVisible = adapterPosition == list.lastIndex
//              btnStart.isVisible = adapterPosition != list.lastIndex
                btnStart.setOnClickListener { onClick() }
            }

        }
    }
}
