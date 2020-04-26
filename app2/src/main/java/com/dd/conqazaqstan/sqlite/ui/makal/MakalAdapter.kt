package com.dd.conqazaqstan.sqlite.ui.makal

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import com.carmabs.ema.android.ui.EmaRecyclerAdapter
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.dd.conqazaqstan.sqlite.R
import com.dd.domain.model.MakalModel
import kotlinx.android.synthetic.main.item_makal.view.*

class MakalAdapter(private val context: Context,
                   override val listItems: MutableList<MakalModel> = mutableListOf(),
                   private val itemListener: (MakalModel) -> Unit) : EmaRecyclerAdapter<MakalModel>() {
    override val layoutItemId: Int = R.layout.item_makal

    override fun View.bind(item: MakalModel, viewType: Int) {
        tvBranch.text = item.branch
        tvPhone.text = item.phone
        tvAddress.text = item.address
        tvSchedule.text = item.schedule

        ivCopy.setOnClickListener {
            YoYo.with(Techniques.FadeOut).duration(150).repeat(0).playOn(ivCopy)
            YoYo.with(Techniques.FadeIn).duration(350).repeat(0).playOn(ivCopy)

            item.address?.let { it1 -> copyToClipboard(it1) }

            itemListener.invoke(item)
        }
        ivShare.setOnClickListener {
            YoYo.with(Techniques.FadeOut).duration(150).repeat(0).playOn(ivShare)
            YoYo.with(Techniques.FadeIn).duration(350).repeat(0).playOn(ivShare)

            item.address?.let { it1 -> shareText(it1) }

            itemListener.invoke(item)
        }
    }

    private fun copyToClipboard(text: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
        val clip = ClipData.newPlainText("Makal text", text)
        clipboard?.setPrimaryClip(clip)
        Toast.makeText(context, R.string.TextCopied, Toast.LENGTH_SHORT).show()
    }

    private fun shareText(text: String) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, text)
        sharingIntent.putExtra(Intent.EXTRA_TEXT, text)
        context.startActivity(Intent.createChooser(sharingIntent, context.resources.getString(R.string.share_using)))
    }
}