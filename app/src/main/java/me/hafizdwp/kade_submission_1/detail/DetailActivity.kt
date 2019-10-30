package me.hafizdwp.kade_submission_1.detail

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import me.hafizdwp.kade_submission_1.LeagueData
import org.jetbrains.anko.*

/**
 * @author hafizdwp
 * 29/10/2019
 **/

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_LEAGUE_DATA = "extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val leagueData = intent.getParcelableExtra<LeagueData>(EXTRA_LEAGUE_DATA)
        DetailUI(leagueData).setContentView(this)

        // Caused by: java.lang.ClassCastException: org.jetbrains.anko._Toolbar cannot be cast to android.support.v7.widget.Toolbar
        // F this.
        // udah downgrade dari androidx siapa tau bisa
        // kalo pake support toolbar
        // taunya sama aja
//        val toolbar = find<Toolbar>(DetailUI.toolbarId)

//        setSupportActionBar(toolbar)
//        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}

class DetailUI(val data: LeagueData) : AnkoComponent<DetailActivity> {

    companion object {
        val toolbarId = 2000
    }

    override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
        verticalLayout {

            lparams(matchParent, matchParent)
            padding = dip(16)

            toolbar {
                id = toolbarId
            }.lparams(matchParent, wrapContent)

            imageView {
                imageResource = data.imgRes
            }.lparams(matchParent, dip(96)) {
                topMargin = dip(16)
                bottomMargin = dip(16)
            }

            textView {
                text = data.name
                textAlignment = View.TEXT_ALIGNMENT_CENTER
                textSize = sp(18).toFloat()

                setTextColor(Color.BLACK)
                setTypeface(null, Typeface.BOLD)
            }.lparams(matchParent, wrapContent) {
                topMargin = dip(16)
                leftMargin = dip(16)
                rightMargin = dip(16)
                bottomMargin = dip(16)
            }

            textView {
                text = data.description
            }.lparams(matchParent, wrapContent)
        }
    }
}
