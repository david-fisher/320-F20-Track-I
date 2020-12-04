import React , { useState } from 'react';
import {Modal, Button, Collapse} from 'antd';

const HelpMenu = () => {
    const[modalIsOpen, setModalIsOpen] = useState(false)
    const { Panel } = Collapse;

    return (
        <>
            <Button type = "primary" style={{position: "fixed", bottom: "0px", right: "0px"}} onClick={() => setModalIsOpen(true)}>?</Button>
            <Modal 
            visible={modalIsOpen} 
            onOk={() => setModalIsOpen(false)}
            okText="Close"
            closable={false}
            cancelButtonProps={{style:{display:'none'}}}>
            <h2>Help Menu</h2>
                <Collapse>
                    <Panel header="What is the Simulation about?">
                        <p>This simulation will test you ethical situation awareness. Please choose carefully
                            and consciously on what you would really do in a given situation. Your answers
                            will be recorded so answer wisely.
                        </p>
                    </Panel>
                    <Panel header="Is this graded based on how I answer?">
                        <p>No, please answer everything honestly based on how you would appraoch it
                            in real life. The only thing that gets graded is completion.
                        </p>
                    </Panel>
                    <Panel header="Can I exit and have my progress saved?">
                        <p>You can exit out, but your progress will not be saved. You will have to either restart
                            or contact your professor to open up a new simulation for you based on how they
                            set it up.
                        </p>
                    </Panel>
                    <Panel header="Can I attempt this more than once?">
                        <p>This depends on your teacher, look back into (insert place)</p>
                    </Panel>
                    <Panel header="Can I revert my decision?">
                        <p>No you cannot</p>
                    </Panel>
                </Collapse>
            </Modal>
        </>
    );
}

export default HelpMenu;