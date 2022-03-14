package com.ezyretirement.app.models

data class PersonalData(
    var name: String = "",
    var userProfileImageUrl: String = "",
    var occupation: String = "",
    var dob: Long = 0,
    var currentSalary: Double = 0.0,
    var scenario: String = "",
    var currentRetirementNest: Double = 0.0,
    var yearlyContribution: Double = 0.0,
    var estimatedYearlySalary: Double = 0.0,
    var yearsToRetirement: Int = 0,
    var desiredActiveRetirementSalary: Double = 0.0,
    var salaryAfterActiveYears: Double = 0.0,
    var retirementStages: MutableList<RetirementStateModel> = mutableListOf(),
    var isContributionRate:Boolean = false
)
