
syntax on
set title
set fenc=utf-8
set tabstop=4
set showcmd
set number
set cursorline
set virtualedit=onemore
set smartindent
set showmatch
set laststatus=2
set wildmode=list:longest

set ignorecase
set incsearch
set wrapscan
set hlsearch

imap { {}<LEFT>
imap [ []<LEFT>
imap ( ()<LEFT>

set nocompatible
filetype off
if has('vim_starting')
		set runtimepath+=~/.vim/bundle/neobundle.vim
endif

call neobundle#begin(expand('~/.vim/bundle/'))
" insert here your Nepbundle plugins"
NeoBundle 'scrooloose/nerdtree'
NeoBundle 'tomtom/tcomment_vim'

call neobundle#end()

filetype plugin on
