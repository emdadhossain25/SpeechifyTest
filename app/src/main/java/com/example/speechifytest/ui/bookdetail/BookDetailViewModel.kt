package com.example.speechifytest.ui.bookdetail

import androidx.lifecycle.ViewModel
import com.example.speechifytest.data.repository.IBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel @Inject constructor(
    val iBookRepository: IBookRepository
): ViewModel() {
}