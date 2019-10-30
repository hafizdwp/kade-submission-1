package me.hafizdwp.kade_submission_1

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * @author hafizdwp
 * 29/10/2019
 **/
class MainItemUI() : AnkoComponent<ViewGroup> {

    companion object {
        val rootId = 1000
        val imgId = 1001
        val textId = 1002
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        cardView {
            lparams(matchParent, wrapContent)
            useCompatPadding = true
            setContentPadding(16, 16, 16, 16)

            verticalLayout {
                lparams(matchParent, wrapContent)
                id = rootId
                isClickable = true
                isFocusable = true

                imageView {
                    id = imgId
                    layoutParams = LinearLayout.LayoutParams(matchParent, dip(96))
                }

                textView {
                    id = textId
                    layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    padding = dip(8)
                }
            }
        }
    }
}