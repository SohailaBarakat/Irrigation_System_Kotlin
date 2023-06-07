package com.kotlinspring.irrigation_system.exception.handlers

import com.kotlinspring.irrigation_system.exception.AlreadyExistException
import com.kotlinspring.irrigation_system.exception.NotFoundException
import com.kotlinspring.irrigation_system.response.ResponseHandler
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class GeneralExceptionHandler {

    @ExceptionHandler(AlreadyExistException::class)
    fun handleAreadyExistException(ex:AlreadyExistException,req: HttpServletRequest): ResponseEntity<Any> {
        val message =String.format("%s", ex.message)
        return ResponseHandler.generateResponse(message,HttpStatus.valueOf(409),"",false)

    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException, req: HttpServletRequest?): ResponseEntity<Any> {
        val message = java.lang.String.format("%s", ex.message)
        return ResponseHandler.generateResponse(message,HttpStatus.valueOf(405),"",false)
    }



}