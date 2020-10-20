package com.ads.portfolioads.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by FAJAR SEPTIAN on 21/10/20.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */

@Parcelize
@Entity(tableName = "sample_table")
data class SampleEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: String,

    ) : Parcelable
