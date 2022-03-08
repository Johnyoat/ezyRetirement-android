package com.ezyretirement.app.models

data class PersonalData(
    var name: String = "",
    var userProfileImageUrl: String = "",
    var occupation: String = "",
    var dob: Long = 0,
    var currentSalary:Long = 0,
    var scenario:String = "",
    var currentRetirementNest:Long=0,
    var yearlyContribution:Long=0,
    var estimatedYearlySalary:Long=0,
    var yearsToRetirement:Int=0,
    var desiredActiveRetirementSalary:Long=0,
    var salaryAfterActiveYears:Long=0,
)
