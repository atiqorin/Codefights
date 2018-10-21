function paintHouses(cost) {
    var [R, B, G] =[0, 0, 0]
    for(var [r, b, g] of cost) {
        [R, B, G] = [r + Math.min(B, G), b + Math.min(R, G), g + Math.min(R, B)];
    }
    return Math.min(R, B, G);
}
