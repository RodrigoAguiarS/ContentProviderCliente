package com.rodrigo.contentprovidercliente


import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClienteAdpater(private val mCursor: Cursor): RecyclerView.Adapter<ClienteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder =
        ClienteViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.cliente_item, parent, false))

    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
        mCursor.moveToPosition(position)
        holder.clienteTitle.text = mCursor.getString(mCursor.getColumnIndex("title"))
        holder.clienteDescription.text = mCursor.getString(mCursor.getColumnIndex("description"))
    }
    override fun getItemCount(): Int = mCursor.count

}

class ClienteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val clienteTitle = itemView.findViewById(R.id.cliente_item_title) as TextView
    val clienteDescription = itemView.findViewById(R.id.cliente_item_description) as TextView
}