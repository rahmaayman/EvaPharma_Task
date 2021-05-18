package com.evaph.core.base

import com.evaph.network.network.NetworkManager
import javax.inject.Inject

open class BaseRepo {

    @Inject
    lateinit var networkManager: NetworkManager
}