def pressureGauges(morning, evening):
    return [[min(p) for p in zip(morning, evening)], [max(p) for p in zip(morning, evening)]]
