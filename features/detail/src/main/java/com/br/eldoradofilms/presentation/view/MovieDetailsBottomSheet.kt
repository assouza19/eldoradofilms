package com.br.eldoradofilms.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.eldoradofilms.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_COLLAPSED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_HIDDEN
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MovieDetailsBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_movie_details, container, false)
        isCancelable = false
        val bottomSheetBehavior = BottomSheetBehavior.from(view.findViewById(R.id.container))
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED

        return view
    }
}