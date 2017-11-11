def sortStudents(students):
    students.sort(key= lambda s : s.split(' ')[-1] )
    return students
