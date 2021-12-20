
const pageNumbers = (total, max, current) => {
  const half = Math.floor(max / 2);
  let to = max;
  
  if(current + half >= total) {
    to = total;
  } else if(current > half) {
    to = current + half ;
  }
  
  let from = to - max;

  return Array.from({length: max}, (_, i) => (i + 1) + from);
}

function PaginationButton(totalPages, maxPagesVisible = 10, currentPage = 1) {
  let pages = pageNumbers(totalPages, maxPagesVisible, currentPage);
  let currentPageBtn = null;
  const buttons = new Map();
  const disabled = {
    start: () => pages[0] === 1,
    prev: () => currentPage === 1,
    end: () => pages.slice(-1)[0] === totalPages,
    next: () => currentPage === totalPages
  }
  const frag = document.createDocumentFragment();
  const paginationButtonContainer = document.createElement('div');
  paginationButtonContainer.className = 'pagination-buttons';
  paginationButtonContainer.id = 'pagination-buttons';
  
  const createAndSetupButton = (label = '', cls = '', disabled = false, handleClick) => {
    const buttonElement = document.createElement('button');
    buttonElement.textContent = label;
	buttonElement.value = label;
    buttonElement.className = `page-btn ${cls}`;
    buttonElement.disabled = disabled;
    buttonElement.addEventListener('click', e => {
      handleClick(e);
      this.update();
      paginationButtonContainer.value = currentPage;
      paginationButtonContainer.dispatchEvent(new Event('change'));
    });
    
    return buttonElement;
  }
  
  const onPageButtonClick = e => currentPage = Number(e.currentTarget.textContent);
  
  const onPageButtonUpdate = index => (btn) => {
    btn.textContent = pages[index];
    
    if(pages[index] === currentPage) {
      currentPageBtn.classList.remove('active');
      btn.classList.add('active');
      currentPageBtn = btn;
      currentPageBtn.focus();
    }
  };
  
  buttons.set(
    createAndSetupButton('start', 'start-page', disabled.start(), () => currentPage = 1),
    (btn) => btn.disabled = disabled.start()
  )
  
  buttons.set(
    createAndSetupButton('prev', 'prev-page', disabled.prev(), () => currentPage -= 1),
    (btn) => btn.disabled = disabled.prev()
  )
  
  pages.map((pageNumber, index) => {
    const isCurrentPage = currentPage === pageNumber;
    const button = createAndSetupButton(
      pageNumber, isCurrentPage ? 'active' : '', false, onPageButtonClick
    );
    
    if(isCurrentPage) {
      currentPageBtn = button;
    }
    
    buttons.set(button, onPageButtonUpdate(index));
  });
  
  buttons.set(
    createAndSetupButton('next', 'next-page', disabled.next(), () => currentPage += 1),
    (btn) => btn.disabled = disabled.next()
  )
  
  buttons.set(
    createAndSetupButton('end', 'end-page', disabled.end(), () => currentPage = totalPages),
    (btn) => btn.disabled = disabled.end()
  )
  
  buttons.forEach((_, btn) => frag.appendChild(btn));
  paginationButtonContainer.appendChild(frag);
  
  this.render = (container = document.getElementById('pagination')) => {
    container.appendChild(paginationButtonContainer);
  }
  
  this.update = (newPageNumber = currentPage) => {
    currentPage = newPageNumber;
    pages = pageNumbers(totalPages, maxPagesVisible, currentPage);
    buttons.forEach((updateButton, btn) => updateButton(btn));
  }
  
  this.onChange = (handler) => {
    paginationButtonContainer.addEventListener('change', handler);
  }
}

let table = document.querySelector('#gems')

let tableHeader = {uniqueName:'Unique Name', gemType:'Gem Type', country:'Country', town:'Town', miningPlace:'Mining Place', preciousness:'Preciousness', color:'Color', transparency:'Transparency', hardness:'Hardness', weight:'Weight', addDate:'Add Date'};

let itemCounter = gems.length;

let itemsPerPage = 5;

let pageSelectorCounter = 5;

let pages = Math.ceil(itemCounter / itemsPerPage);

if(pages < pageSelectorCounter) {
	pageSelectorCounter = pages;
}

const paginationButtons = new PaginationButton(pages, pageSelectorCounter);

paginationButtons.render();

var paginationElements = document.getElementsByClassName('page-btn')
var pageNumbersArray = []

for(i = 2; i < paginationElements.length-2; i++) {
	pageNumbersArray.push(paginationElements[i])
}

paginationElements[2].click();
showPage(pageNumbersArray[0])


for(let pageNumberQuery of pageNumbersArray) {
	pageNumberQuery.addEventListener('click', function(){
		showPage(pageNumberQuery);
	});
}

function showPage(activePage) {
	let pageNum = activePage.value;
		let start = (pageNum - 1) * itemsPerPage;
		let end = start + itemsPerPage;
		let notes = gems.slice(start, end);
		table.innerHTML = '';
		let tableHeaderRow = document.createElement('tr');
		table.appendChild(tableHeaderRow);
		fillTableHeaderRow(tableHeader, tableHeaderRow);
		for(let note of notes) {
			let tableRow = document.createElement('tr');
			table.appendChild(tableRow);
			fillTableDataRow(note, tableRow);
		}
}

function createTableDataCell(objectFieldData, tableRow) {
	let tableDataCell = document.createElement('td')
	tableDataCell.innerHTML = objectFieldData;
	tableRow.appendChild(tableDataCell);
}


function createTableHeaderCell(headerFieldData, tableRow) {
	let tableHeaderCell = document.createElement('th')
	tableHeaderCell.innerHTML = headerFieldData;
	tableRow.appendChild(tableHeaderCell);
}

function fillTableHeaderRow(tableHeader, tableHeaderRow) {
	createTableHeaderCell(tableHeader.uniqueName, tableHeaderRow);
	createTableHeaderCell(tableHeader.gemType, tableHeaderRow);
	createTableHeaderCell(tableHeader.country, tableHeaderRow);
	createTableHeaderCell(tableHeader.town, tableHeaderRow);
	createTableHeaderCell(tableHeader.miningPlace, tableHeaderRow);
	createTableHeaderCell(tableHeader.preciousness, tableHeaderRow);
	createTableHeaderCell(tableHeader.color, tableHeaderRow);
	createTableHeaderCell(tableHeader.transparency, tableHeaderRow);
	createTableHeaderCell(tableHeader.hardness, tableHeaderRow);
	createTableHeaderCell(tableHeader.weight, tableHeaderRow);
	createTableHeaderCell(tableHeader.addDate, tableHeaderRow);
}

function fillTableDataRow(note, tableRow) {
	createTableDataCell(note.gemUniqueName, tableRow);
	createTableDataCell(note.gemType, tableRow);
	createTableDataCell(note.gemOriginPlace.country, tableRow);
	createTableDataCell(note.gemOriginPlace.town, tableRow);
	createTableDataCell(note.gemOriginPlace.miningCamp, tableRow);
	createTableDataCell(note.gemPreciousness, tableRow);
	createTableDataCell(note.gemColor, tableRow);
	createTableDataCell(note.gemTransparency, tableRow);
	createTableDataCell(note.gemHardness, tableRow);
	createTableDataCell(note.gemWeightValue, tableRow);
	createTableDataCell(note.gemAddTimeStamp, tableRow);
}



