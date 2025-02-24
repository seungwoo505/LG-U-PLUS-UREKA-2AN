function solution(n, t, m, p) {
    let number = 0;
    let string = "";
    let count = 1;
    
    while(string.length < t){
        let num = number.toString(n).toUpperCase();
        
        for(let i of num){
            if(count === p) string += i;
            
            if(count === m) count = 1;
            else count++;
            
            if(string.length === t) return string
        }
        number++;
    }
    
    return string;
}