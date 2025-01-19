package com.a1developers.taazakhabar.domain.usecases.app_entry

import com.a1developers.taazakhabar.domain.manager.LocalUserManager

class SaveAppEntry (

    private val localusermanager : LocalUserManager
){

    suspend operator fun invoke(){
        localusermanager.saveAppEntry()
    }
}