package com.acexams.aceexam.firebase

import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

class FcmInstanceIdService: FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
        super.onTokenRefresh()
        var token:String= FirebaseInstanceId.getInstance().getToken().toString()
        shareprefrences.setStringPreference(this, "FCM_TOKEN", token)
    }
}