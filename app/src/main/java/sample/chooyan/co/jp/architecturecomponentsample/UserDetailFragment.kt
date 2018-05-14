package sample.chooyan.co.jp.architecturecomponentsample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_user_detail.*

class UserDetailFragment : Fragment() {

    var userDetailViewModel: UserDetailViewModel? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.layout_user_detail, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val id = arguments.getInt("key_id")
        userDetailViewModel = ViewModelProviders.of(this).get(UserDetailViewModel::class.java)
        userDetailViewModel?.init(id)

        userDetailViewModel?.getUser()?.observe( activity, Observer {user ->
            user_id.setText(user?.id.toString())
            user_name.setText(user?.name)
            user_detail.setText(user?.description)
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param2 Parameter 2.
         * @return A new instance of fragment PostListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
                UserDetailFragment().apply {
                    arguments = Bundle().apply {
                        putInt("key_id", param1)
                    }
                }
    }
}