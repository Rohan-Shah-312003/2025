package main

import (
	"fmt"
	// "math"
	// "sort"
	// "strings"
)

func main() {
	// fmt.Println("Hello World")

	// strings
	// var nameOne string = "Rohan"
	// var nameTwo = "Kiran"
	// fmt.Println(nameOne)
	// fmt.Println(nameTwo)
	//
	// var nameThree string
	// fmt.Print(nameThree)
	// nameThree = "Ruma"
	// fmt.Println(nameThree)

	// ints
	// var ageOne int = 20
	// var ageTwo = 30
	// ageThree := 40
	//
	// var numOne int8 = 25
	// var numTwo int8 = -128
	// var numThree uint16 = 256
	//
	// // float
	//
	// var scoreOne float32 = 25.98
	// var scoreTwo float64 = 542376589565982765872.53467
	// scoreThree := 1.56

	// fmt.Printf("my name is %v and my age is %v \n", nameOne, ageOne)
	// fmt.Printf("age is of type %T", ageOne)

	// array

	// var ages [3]int = [3]int{25, 25, 30}
	// var ages = [3]int{25, 25, 30}
	// fmt.Println(ages, len(ages))
	// names := []string{"rohan", "kiran", "ruma", "indra"}
	//
	// fmt.Println(names, len(names))

	// slices -> use array underneath but have flexible length and can append

	// var scores = []int{21, 29, 63}
	// scores[2] = 53
	// scores = append(scores, 55)
	//
	// fmt.Println(scores, len(scores))
	//
	// greeting := "hello good morning!"
	//
	// fmt.Println(strings.Contains(greeting, "hello"))
	// fmt.Println(strings.ReplaceAll(greeting, "hello", "hi"))
	//
	// agesTwo := []int{45, 20, 35, 30, 75, 60, 60, 50, 25}
	// sort.Ints(agesTwo)
	// fmt.Println(agesTwo)
	// sort.Strings(names)
	// fmt.Println(names)

	// Loops

	// x := 0
	// for x < 5 {
	// 	fmt.Println("value of x: ", x)
	// 	x++
	// }

	// for i := 0; i < 5; i++ {
	// 	fmt.Println("value of i: ", i)
	// }

	// for index, value := range names {
	// 	fmt.Printf("the value at index %v is %v \n", index, value)
	// }

	// for _, value := range names {
	// 	fmt.Printf("the value at index %v is %v \n", index, value)
	// }

	// for index, _ := range names {
	// 	fmt.Printf("the value at index %v is %v \n", index, value)
	// }

	// conditional statements

	// age := 20
	// if age < 30 {
	// 	fmt.Println("< 30")
	// } else if age < 40 {
	// 	fmt.Println("< 40")
	// } else {
	// 	fmt.Println("age is 20")
	// }

	// for index, value := range names {
	// 	if index == 1 {
	// 		fmt.Println("continuing at pos", index)
	// 		continue
	// 	}
	//
	// 	if index > 2 {
	// 		break
	// 	}
	//
	// 	fmt.Printf("the value at pos %v is %v \n", index, value)
	// }

	// Functions

	// sayHello("Rohan")
	// sayGoodBye("Rohan")
	// cycleNames([]string{"rohan", "kiran", "ruma", "indra"}, sayHello)
	// cycleNames([]string{"rohan", "kiran", "ruma", "indra"}, sayGoodBye)
	// fmt.Printf("%0.3f \n", circleArea(12))

	// Multiple return values
	// fn1, sn1 := getInitials("tifa Lockhart") // assigning two variables on the same line like python
	// fmt.Println(fn1, sn1)
	// fn2, sn2 := getInitials("rohan")
	// fmt.Println(fn2, sn2)

    sayHello("rohan")

    for _, v := range points {
        fmt.Println(v)
    }



}

// User defined functions
// func sayHello(n string) {
// 	fmt.Println("hello, ", n)
// }
//
// func sayGoodBye(n string) {
// 	fmt.Println("bye,", n)
// }
//
// func cycleNames(n []string, f func(string)) {
// 	for _, v := range n {
// 		f(v)
// 	}
// }
//
// func circleArea(r float64) float64 {
// 	return math.Pi * r * r
// }
//
// func getInitials(n string) (string, string) {
// 	s := strings.ToUpper(n)
// 	names := strings.Split(s, " ")
//
// 	var initials []string
//
// 	for _, v := range names {
// 		initials = append(initials, v[:1])
// 	}
//
// 	if len(initials) > 1 {
// 		return initials[0], initials[1]
// 	}
//
// 	return initials[0], "_"
// }
