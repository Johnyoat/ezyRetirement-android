package com.ezyretirement.app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ezyretirement.app.databinding.RetirementStageItemBinding
import com.ezyretirement.app.models.RetirementStateModel

class RetirementStageListAdapter(
    private val retirementStageLists: List<RetirementStateModel>,
    private val context: Context
) : RecyclerView.Adapter<RetirementStageListAdapter.RetirementStateListViewHolder>() {


    inner class RetirementStateListViewHolder(private val itemView: RetirementStageItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        fun setUpData(state: RetirementStateModel) {

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RetirementStateListViewHolder {
        return RetirementStateListViewHolder(
            RetirementStageItemBinding.inflate(
                LayoutInflater.from(
                    context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RetirementStateListViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = retirementStageLists.size
}