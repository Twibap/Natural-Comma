package io.github.twibap.comma.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioGroup
import io.github.twibap.comma.R
import io.github.twibap.comma.model.Mart

class MainFragment : Fragment(), CompoundButton.OnCheckedChangeListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var checkApple: CheckBox
    private lateinit var checkBerry: CheckBox
    private lateinit var checkBanana: CheckBox
    private lateinit var checkPeach: CheckBox
    private lateinit var checkPlum: CheckBox

    private lateinit var openOrClose: RadioGroup

    private val mart = Mart()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        checkApple = view.findViewById(R.id.checkApple)
        checkBerry = view.findViewById(R.id.checkBerry)
        checkBanana = view.findViewById(R.id.checkBanana)
        checkPeach = view.findViewById(R.id.checkPeach)
        checkPlum = view.findViewById(R.id.checkPlum)

        openOrClose = view.findViewById(R.id.selectOpenOrClose)

        checkApple.setOnCheckedChangeListener(this)
        checkBerry.setOnCheckedChangeListener(this)
        checkBanana.setOnCheckedChangeListener(this)
        checkPeach.setOnCheckedChangeListener(this)
        checkPlum.setOnCheckedChangeListener(this)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        val flag = when (p0?.id) {
            R.id.checkApple -> Mart.Flag.APPLE
            R.id.checkBerry -> Mart.Flag.BERRY
            R.id.checkBanana -> Mart.Flag.BANANA
            R.id.checkPeach -> Mart.Flag.PEACH
            R.id.checkPlum -> Mart.Flag.PLUM
            else -> Mart.Flag.IS_OPEN
        }

        mart.toggleFlag(flag)
    }

}