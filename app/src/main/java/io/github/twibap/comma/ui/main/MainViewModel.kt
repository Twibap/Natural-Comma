package io.github.twibap.comma.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.twibap.comma.model.Mart

class MainViewModel : ViewModel() {

    val martLiveData: MutableLiveData<Mart> = MutableLiveData<Mart>()

}