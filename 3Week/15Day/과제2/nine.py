def solution(array, height):
    array.append(height)
    array.sort(reverse=True)
    for i in range(len(array)):
        if array[i] == height:
            return i