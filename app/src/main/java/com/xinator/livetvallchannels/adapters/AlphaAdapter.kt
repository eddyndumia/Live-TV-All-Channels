package com.xinator.livetvallchannels.adapters

import android.content.Context
import android.system.Os.bind
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.system.Os.bind
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.xinator.livetvallchannels.MainActivity
import com.xinator.livetvallchannels.R
import com.xinator.livetvallchannels.model.AlphaChar
import org.w3c.dom.Text

class AlphaAdapter(var context: Context, var arrayList: ArrayList<AlphaChar>): RecyclerView.Adapter<AlphaAdapter.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.grid_layout_item, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var alphaChar: AlphaChar = arrayList.get(position)
        holder.itemView.setOnClickListener {
            MaterialDialog(holder.icons.context).show {
                title(text = "Locked")
                message(text = "To Watch ${holder.alphas.text}, you must watch 3 Ads to Unlock for a Lifetime.")
                positiveButton(R.string.watchad) { dialog ->
                    Toast.makeText(context,R.string.loadad,Toast.LENGTH_LONG).show()
                }
            }
        }
        holder.icons.setImageResource(alphaChar.iconsChar!!)
        holder.alphas.text = alphaChar.alphaChar
        holder.alphas.setOnClickListener {
            Toast.makeText(context, alphaChar.alphaChar, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ItemHolder(item: View) : RecyclerView.ViewHolder(item) {
        var icons = itemView.findViewById<ImageView>(R.id.tvicon)
        var alphas = itemView.findViewById<TextView>(R.id.titles)

    }
}
