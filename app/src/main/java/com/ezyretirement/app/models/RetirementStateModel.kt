package com.ezyretirement.app.models

data class RetirementStateModel(
    var beginningBalance: Double = 0.0,
    var withdraw: Double = 0.0,
    var interest: Double = 0.0,
    var endBalance: Double = 0.0,
    var year: String = ""
)