package com.example.ca02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FixtureAdapter : RecyclerView.Adapter<FixtureAdapter.FixtureViewHolder>() {
    private var fixtures = emptyList<Fixture>()

    class FixtureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val teamA: TextView = itemView.findViewById(R.id.textTeamA)
        val teamB: TextView = itemView.findViewById(R.id.textTeamB)
        val matchDate: TextView = itemView.findViewById(R.id.textMatchDate)
        val venue: TextView = itemView.findViewById(R.id.textVenue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixtureViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fixture_item, parent, false)
        return FixtureViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FixtureViewHolder, position: Int) {
        val fixture = fixtures[position]
        holder.teamA.text = fixture.teamA
        holder.teamB.text = fixture.teamB
        holder.matchDate.text = fixture.matchDate
        holder.venue.text = fixture.venue
    }

    override fun getItemCount() = fixtures.size

    fun submitList(fixtureList: List<Fixture>) {
        fixtures = fixtureList
        notifyDataSetChanged()
    }
}