def checkParticipants(participants):
    return [i for i, e in filter(lambda (i, e) : e < i, enumerate(participants))]
