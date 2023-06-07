package com.kotlinspring.irrigation_system.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ResponseHandler {
//    public fun generateResponse(message:String,status:HttpStatus,responseObject:Any?,success:Boolean):ResponseEntity<Any>{
//        val map = hashMapOf<String,Any>()
//        map["message"] = message
//        map["status"] =status.value()
//        map["data"] = responseObject as Any
//        map["success"] = success
//
//        return ResponseEntity(map,status)
//    }

    companion object {
        fun generateResponse(message:String, status:HttpStatus, responseObject: Any?, success:Boolean):ResponseEntity<Any>{
            val map = hashMapOf<String,Any>()
            map["message"] = message
            map["status"] =status.value()
            map["data"] = responseObject as Any
            map["success"] = success

            return ResponseEntity(map,status)
    }
}}
