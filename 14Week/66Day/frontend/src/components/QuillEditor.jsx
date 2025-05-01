import { useRef } from 'react'
import ReactQuill from 'react-quill-new'
import 'react-quill-new/dist/quill.snow.css'
import './QuillEditor.css'

const QuillEditor = ({ value, onChange, placeholder }) => {
  const quillRef = useRef(null)

  // 이미지 핸들러 함수
  const imageHandler = () => {
    const input = document.createElement('input')
    input.setAttribute('type', 'file')
    input.setAttribute('accept', 'image/*')
    input.click()

    input.onchange = async () => {
      const file = input.files[0]
      if (!file) return

      try {
        // 서버에 이미지 업로드 하는 방식 (선택 사항)
        const formData = new FormData()
        formData.append('image', file)

        // 로컬 미리보기를 위한 임시 URL 생성
        const reader = new FileReader()
        let tempImageUrl = ''

        reader.onload = () => {
          tempImageUrl = reader.result
          // 에디터에 임시 이미지 삽입
          const range = quillRef.current.getEditor().getSelection(true)
          quillRef.current.getEditor().insertEmbed(range.index, 'image', tempImageUrl)
          quillRef.current.getEditor().setSelection(range.index + 1)
        }

        reader.readAsDataURL(file)

        // 서버에 이미지 업로드 요청을 보내고 실제 URL로 교체하려면 아래 주석을 해제
        /*
        const response = await fetch('http://localhost:3000/upload-image', {
          method: 'POST',
          body: formData,
          credentials: 'include'
        })
        
        if (!response.ok) {
          throw new Error('이미지 업로드 실패')
        }
        
        const data = await response.json()
        
        // 에디터 내용에서 임시 URL을 실제 서버 URL로 교체
        const serverUrl = data.imageUrl
        if (serverUrl && tempImageUrl) {
          const currentContent = quillRef.current.getEditor().getContents()
          const updatedContent = JSON.stringify(currentContent)
            .replace(tempImageUrl, serverUrl)
          quillRef.current.getEditor().setContents(JSON.parse(updatedContent))
        }
        */
      } catch (error) {
        console.error('이미지 업로드 실패:', error)
        alert('이미지 업로드에 실패했습니다.')
      }
    }
  }

  // Quill 에디터 모듈 설정
  const modules = {
    toolbar: {
      container: [
        [{ header: [1, 2, 3, false] }],
        ['bold', 'italic', 'underline', 'strike'],
        [{ list: 'ordered' }, { list: 'bullet' }],
        ['link', 'image'],
        ['clean'],
      ],
      handlers: {
        image: imageHandler,
      },
    },
  }

  return (
    <div className="quill-editor-container">
      <ReactQuill
        ref={quillRef}
        theme="snow"
        value={value}
        onChange={onChange}
        modules={modules}
        placeholder={placeholder || '내용을 입력해 주세요'}
      />
    </div>
  )
}

export default QuillEditor
