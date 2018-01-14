def transposeDictionary(scriptByExtension):
    return sorted([[scriptByExtension[key], key] for key in scriptByExtension.keys()])
