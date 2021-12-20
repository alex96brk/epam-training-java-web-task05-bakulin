const file = document.querySelector('#file');
file.addEventListener('change', (e) => {
	const fileName = e.target.files[0].name
 	document.querySelector('.file-name').textContent = fileName;
});