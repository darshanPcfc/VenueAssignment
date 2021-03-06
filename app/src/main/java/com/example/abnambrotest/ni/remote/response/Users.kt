package com.example.abnambrotest.ni.remote.response

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_name")
data class Users(
    @NonNull
    @ColumnInfo(name = "avatar_url")
    var avatar_url: String? = "",
    @NonNull
    @ColumnInfo(name = "display_name")
    var display_name: String? = "",
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int? = null,
    @NonNull
    @ColumnInfo(name = "user_name")
    var username: String? = null
) {


    companion object {
        // important code for loading image here
        /*@JvmStatic
        @BindingAdapter("avatar")
        fun loadImage(display_image: ImageView, avatar_url: String) {

            Glide.with(display_image.getContext())
                .setDefaultRequestOptions(
                    RequestOptions()
                        .circleCrop()
                )
                .load(avatar_url)
                .placeholder(R.drawable.ic_place_holder)
                .into(display_image)
        }*/
    }

}