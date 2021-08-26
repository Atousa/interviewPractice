

public static int kth_largest_in_an_array(List<Integer> numbers, int k) {

        if(numbers.size() == 0 || k > numbers.size()) return -1;

        quickSelect(numbers, 0, numbers.size()-1, k);
        return numbers.get(numbers.size() - k);

        }

private static void quickSelect(List<Integer> numbers, int start, int end, int k) {


        if(start == numbers.size() - k ) return;

        int pivotIdx = partition(numbers, start, end, k);


        if ( pivotIdx < numbers.size() - k) {
        quickSelect(numbers, pivotIdx+1, end, k);

        } else
        quickSelect(numbers, start, pivotIdx-1, k);
        }

private static int partition(List<Integer> numbers, int start, int end, int k) {
        Random rnd = new Random();
        int range = end - start + 1;
        int pivotIdx = rnd.nextInt(range) + start ;
        Collections.swap(numbers, pivotIdx, start);

        int greater = start +1 ;
        int smaller = start;
        int pivot = numbers.get(start);

        while (greater <= end) {
        if (numbers.get(greater) < pivot
                || numbers.get(greater).equals(pivot) && greater%2 == 0 ) {
                        smaller++;
                        Collections.swap(numbers, smaller, greater);

                        }
                        greater++;
                        }

                        Collections.swap(numbers, start, smaller);
                        //System.out.println(start + " "+ end + " " + pivotIdx +" " + smaller);
                        return smaller;
                        }

                        




