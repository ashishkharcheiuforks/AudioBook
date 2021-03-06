package com.allsoftdroid.audiobook.audiobookListFragment.repository

import androidx.lifecycle.MutableLiveData
import com.allsoftdroid.common.base.network.Failure
import com.allsoftdroid.common.base.network.Success
import com.allsoftdroid.feature_book.domain.model.AudioBookDomainModel
import com.allsoftdroid.feature_book.domain.repository.AudioBookRepository
import com.allsoftdroid.feature_book.domain.repository.NetworkResponseListener

class FakeAudioBookRepository(private val manualFailure:Boolean = false) : AudioBookRepository{
    private var listener:NetworkResponseListener? = null

    companion object{
        const val FAILURE_MESSAGE="Manual Failure triggered"
    }

    override fun registerNetworkResponse(listener: NetworkResponseListener) {
        this.listener = listener
    }

    override fun unRegisterNetworkResponse() {
        listener = null
    }

    private var audioBooks = MutableLiveData<List<AudioBookDomainModel>>()

    override suspend fun fetchBookList(page: Int) {
        if(!manualFailure){
            val list = ArrayList<AudioBookDomainModel>()
            list.add(AudioBookDomainModel("1","Title","creator","2019-12-01'T'11:11:00'Z'"))

            audioBooks.value = list

            listener?.onResponse(Success(result = list.size))
        }else{
            audioBooks.value = emptyList()

            listener?.onResponse(Failure(error = Error(FAILURE_MESSAGE)))
        }
    }

    override fun getAudioBooks()= audioBooks
}