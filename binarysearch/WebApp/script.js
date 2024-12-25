document.getElementById('startSearch').addEventListener('click', startBinarySearch);

async function startBinarySearch() {
    const arrayInput = document.getElementById('arrayInput').value;
    const target = parseInt(document.getElementById('targetValue').value);

    if (!arrayInput || isNaN(target)) {
        alert("Please enter both an array and a target value!");
        return;
    }

    const array = arrayInput.split(',').map(Number);
    const originalArrayDiv = document.getElementById('originalArray');
    const sortedArrayDiv = document.getElementById('sortedArray');
    const resultText = document.getElementById('resultText');
    const notFoundText = document.getElementById('notFoundText');
    const indexSpan = document.getElementById('index');
    const iterationsText = document.getElementById('iterationsText');

    // Clear previous content
    originalArrayDiv.innerHTML = '';
    sortedArrayDiv.innerHTML = '';
    resultText.style.display = 'none';
    notFoundText.style.display = 'none';
    iterationsText.textContent = '';

    // Display Original Array
    array.forEach(num => {
        const element = document.createElement('div');
        element.textContent = num;
        originalArrayDiv.appendChild(element);
    });

    // Perform Binary Search via API
    const response = await fetch(`http://localhost:8080/api/binary-search/search?target=${target}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(array),
    });

    if (!response.ok) {
        alert('Error: ' + response.statusText);
        return;
    }

    const result = await response.json();

    // Display Sorted Array and handle highlighting logic
    result.sortedArray.forEach((num, index) => {
        const element = document.createElement('div');
        element.textContent = num;
        sortedArrayDiv.appendChild(element);
    });

    // Check if the element was found
    if (result.message.includes("Element found")) {
        resultText.style.display = 'block';
        indexSpan.textContent = result.message.match(/\d+/)[0]; // Extract index from the message

        // Highlight the found element in green
        const foundIndex = result.message.match(/\d+/)[0];
        sortedArrayDiv.children[foundIndex].classList.add('highlight'); // Add green highlight for target
    } else {
        notFoundText.style.display = 'block';

        // If not found, highlight the entire sorted array in red
        Array.from(sortedArrayDiv.children).forEach(child => {
            child.classList.add('not-found'); // Add red highlight for all elements
        });
    }

    iterationsText.textContent = `Iterations: ${result.iterations}`;
}
