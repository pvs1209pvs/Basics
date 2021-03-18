#include <iostream>
#include <algorithm>
#include <vector>
#include <random>       // std::default_random_engine
#include <chrono>       // std::chrono::system_clock


int main(){

  int a1[]{1,2,3,4,5,6,7,8,9,10};
  int a2[]{1, 2, 3};

  std::vector<int> v1(std::begin(a1), std::end(a1));

  v1.erase(std::remove(begin(v1), end(v1), 5), v1.end());
  //v1.erase(v1.begin());

  for(auto x : v1){
    std::cout << x << std::endl;
  }


  return 0;
}

/*

HEAP
1. std::make_heap(v.begin(), v.end())
2. std::push_heap(v.begin(), v.end()); // when an element is added to vector v.
3. std::pop_heap(v.begin(), v.end()); // sends the root element at the end of the vector, which then can be revmoed from the vector.


SORTING
4. std::parital_sort(v.begin(), v.begin()+i, v.end()); Rearranges the elements in the range [first,last), in such a way that the elements before middle are the smallest elements in the entire range and are sorted in ascending order, while the remaining elements are left without any specific order.
5. std:nth_element(first, nth, last); place nth where it should be in a sorted sequence. Elemnts towards the left are smaller than nth element and elements towards right are greater than nth element with no specific order.


PERMUTATIONS
6. std::rotate
7. std::shuffle(begin(), end(), randomGen);
8. std::reverse
9. std::next_permutation(begin(),end()); returns true if there are anymore permutations left.
10. std::prev_permutation(begin(),end()); returns true if there are anymore permutations left.


SECRET RUNES
11. stable_  stable_sort, stable_partition. Sorts and pratitions in stable format.
12. is_  is_sorted, is_partitoned
13. is_*_until


NUMERIC
14. std::inner_product(v1.begin(), v1.begin(), v2.begin(), accumulator); return the final value of inner product.
15. std::adjacent_difference(v1.begin(), v1.end(), arrayOfDiff); difference of adjacent element is stored in arrayOfDiff.


QUERRIES
16. std::equal(v1.begin(), v1.end(), v2.begin(), predicate); returns true if v1 and v2 have the exact same element in the exact same order.
17. std::is_permutation(v1.begin(), v1.end(), v2.begin()); returns true if v1 and v2 contain the same element not nessicarly in the same order. It just check if v2 has all the elements v1 has.
18. std::lexicographical_compare
19. std::mismatch(v1.begin(), v1.end(), v2.begin()); returns a pair<iterator, interator> where the two collections differ.
20. std::find(v.begin(), v.end(), value); return the iterator for the element that has been found, else std::end is returned.
21. std::adjacent_find(v.begin(), v.end(), value); returns interator for the first element where the two adjacnet values are same. If value at index 5 and 6 are equal it will return iterator for element at index 5.
22. std::equal_range(v.begin(), v.end(), value); A pair object, whose member pair::first is an iterator to the lower bound of the subrange of equivalent values, and pair::second its upper bound. The values are the same as those that would be returned by functions lower_bound and upper_bound respectively.
23. std::lower_bound(); std::upper_bound(); returns iterator for lower and upper bound of equivalent range.
24. std::binary_search(v.begin(), v.end(), value); returns true if element searched for is present and false otherwise. Doesn't tell where the element is if it exists.
25. std::search(); searches for the sub-range in the bigger range.
26. std::find_end(); searches for the sub-range in the bigger range but searches from the end of the bigger range.
27. std::max_element(); std::min_element(); std::minmax_element(); First two return iterator and the last one returns a pair.


SET ALGO
28. std::set_difference();
29. std::intersection();
30. std::set_union();
31. std::symetric_difference.
32. std::merge();
33. std;:includes();


MOVERS
34. std::copy(v1.begin(), v1.end(), out.begin());
35. std::copy_backward(v1.begin(), v1.end(), v1.begin());
36. std::move(v1.begin(), v1.end(), out.begin());
37. std::move_backward(v1.begin(), v1.end(), v1.begin()); copies elements from v1 to out by calling move constructor on every element from v1.
38. std::swap_ranges(v1.begin(), v1.end(), v2.begin()); swaps elements between v1 and v2.


VALUE MODIFIERS
39. std::fill(v1.first(), v1.end(), value);
40. std::generate(v1.first, v1.end(), function);
41. std::iota(v1.first(), v1.end(), value); Starts with value and keeps on incrementing until it the collection is full.
42. std::replace(v1.first(), v1.end(), old_value, new_value); replaces every occurence of old_value with new_value.


CHANGING STRUCTURE
43. std::remove(begin(collection), end(collection), value); Pushes every occurence of value at the back of the collection because iterator cannot change the size of the collection. The value moved at the back are just garbage values.
44. std::unique(); removes adjacent duplicate values.
45. *_copy they leave the original array untouched.
46. *_if


LONELY ISLANDS
47. std::transforms(); applies the function on every element of the collection.
48. std::for_each(begin(collection), end(collection), f); applies f to every element. It doesn't care what f returns.

*/
