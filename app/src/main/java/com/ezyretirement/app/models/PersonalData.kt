package com.ezyretirement.app.models

data class PersonalData(
    val name: String = "",
    val userProfileImageUrl: String = "",
    val occupation: String = "",
    val dob: Long = 0,
    val currentSalary:Long = 0,
    val scenario:String = "",
    val currentRetirementNest:Long=0,
    val yearlyContribution:Long=0,
    val estimatedYearlySalary:Long=0,
    val yearsToRetirement:Int=0,
    val desiredActiveRetirementSalary:Long=0,
    val salaryAfterActiveYears:Long=0,
)
