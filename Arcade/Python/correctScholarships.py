def correctScholarships(bestStudents, scholarships, allStudents):
    return set(bestStudents) <= set(scholarships) < set(allStudents)
