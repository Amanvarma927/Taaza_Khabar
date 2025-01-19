package com.a1developers.taazakhabar.domain.usecases.app_entry

import com.a1developers.taazakhabar.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(


    private val localusermanager: LocalUserManager,
) {

     operator fun invoke(): Flow<Boolean>  {
       return localusermanager.readAppEntry()
    }
}