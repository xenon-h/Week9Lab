var addModal = document.getElementById("AddUser");
var editModal = document.getElementById("EditUser");
var modalCont = document.getElementById("modalContainer");

function add() {
    addModal.parentNode.style.display = "block";
}
;

function edit() {
    editModal.parentNode.style.display = "block";
}
;

function closeModal() {
    this.parentNode.parentNode.style.display =  "none";
};

document.getElementById('addUserCloseButton').onclick = closeModal;
document.getElementById('editUserCloseButton').onclick = closeModal;

