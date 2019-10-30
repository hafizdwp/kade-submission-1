package me.hafizdwp.kade_submission_1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import me.hafizdwp.kade_submission_1.detail.DetailActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.verticalLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainUI().setContentView(this)
    }
}


class MainUI : AnkoComponent<MainActivity> {

    var mAdapter: MainAdapter? = null
    var mItemClickListener: MainActionListener? = null

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        mItemClickListener = object : MainActionListener {
            override fun onClick(data: LeagueData) {
                startActivity<DetailActivity>(
                        DetailActivity.EXTRA_LEAGUE_DATA to data)
            }
        }

        mAdapter = MainAdapter(
                items = LeagueData.getAll(),
                listener = mItemClickListener!!)

        // Layout-start
        verticalLayout {
            recyclerView {
                adapter = mAdapter
                layoutManager = GridLayoutManager(ctx, 2)
                itemAnimator = null
            }
        }
    }
}


